$HOURLY_JOB_NAME="每小时执行一次"
$HOURLY_JOB_FILE="D:\Bin\tasks\hourly.ps1"

$DAILY_JOB_NAME="每天执行一次"
$DAILY_JOB_FILE="D:\Bin\tasks\daily.ps1"

Register-ScheduledJob -Name $HOURLY_JOB_NAME -FilePath $HOURLY_JOB_FILE
$HOURLY_TIGGER = New-JobTrigger -Once -At "06:00" -RepetitionInterval "01:00:00" -RepeatIndefinitely
Add-JobTrigger -Name $HOURLY_JOB_NAME -Trigger $HOURLY_TIGGER

Register-ScheduledJob -Name $DAILY_JOB_NAME -FilePath $DAILY_JOB_FILE
$DAILY_TIGGER = New-JobTrigger -Daily -At "9:20" -DaysInterval 1
Add-JobTrigger -Name $DAILY_JOB_NAME -Trigger $DAILY_TIGGER