# 更新node.exe文件
$BASE_URL = "https://nodejs.org/dist/latest/"
$PLATFORM = "win-x64"
$EXEC = "node.exe"
$BASE = "D:\Apps\Node\"
$SUFFIX = ".download"

function Get-RemotePackageInfo {
    param (
        [string] $Url,
        [string] $Version
    )
    $result = @{}
    try {
        $Response = Invoke-WebRequest -Uri $Url
        $list = ConvertFrom-Csv -InputObject $Response -Header "shasum", "temp", "version" -Delimiter " "
        foreach ($item in $list) {
            if ($item.version -eq $Version) {
                $result['shasum'] = $item.shasum
            }
            if ($item.version -like "*win-x64.zip") {
                $result['version'] = ($item.version -split "-")[1] -replace "v", ""
            }
        }
    }
    catch {
        Write-Log -Msg "获取远程文件信息失败"
        exit 0
    }
    return $result
}

function Get-LocalPackageInfo {
    param (
        [string] $Path
    )
    $result = @{}
    $result['shasum'] =  (Get-FileHash -Path $Path -Algorithm SHA256).Hash
    $result['version'] = (Get-Item -Path $Path).VersionInfo.ProductVersion
    return $result
}

function Write-Log ($Msg) {
    Write-Host $Msg
    "[{0}] --- {1}" -f (Get-Date), $Msg | Out-File -Encoding utf8 -Append -FilePath ($BASE + "update.log")
}

function Get-Package {
    param (
        [string] $Url,
        [string] $Dest
    )
    
    try {
        Invoke-WebRequest -Uri $Url -OutFile $Dest
    }
    catch {
        Write-Log -Msg "下载文件失败"
    }
}

function Update-Package {
    param (
        [string] $Src,
        [string] $Dest
    )

    try {
        Remove-Item -Path $Dest
        Rename-Item -Path $Src -NewName $Dest
        Write-Log -Msg "应用更新成功" 
    }
    catch {
        Write-Log -Msg "替换应用失败"
        exit 0
    }
}

$remote = Get-RemotePackageInfo -Url ($BASE_URL + "SHASUMS256.txt") -Version ($PLATFORM + "/" + $EXEC)
$local = Get-LocalPackageInfo -Path ($BASE + $EXEC)

if ($remote["shasum"] -eq $local["shasum"]) {
    Write-Log -Msg ("SHA256不一致")
    Write-Log -Msg ("本地版本[{0}], 最新版本[{1}] - 已经是最新版本" -f $local["version"], $remote["version"])
    exit 0 
}

Write-Log -Msg ("本地版本[{0}], 最新版本[{1}] - 下载最新版本..." -f $local["version"], $remote["version"])
Get-Package -Url ($BASE_URL + $PLATFORM + "/" + $EXEC) -Dest ($BASE + $EXEC + $SUFFIX)

$temp = Get-LocalPackageInfo -Path ($BASE + $EXEC + $SUFFIX)
if ($remote["shasum"] -eq $temp["shasum"]) {
    Write-Log -Msg "文件下载不完整"
    exit 0 
}

Update-Package -Src ($BASE + $EXEC + $SUFFIX) -Dest ($BASE + $EXEC)