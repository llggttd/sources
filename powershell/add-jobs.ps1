$JOB_NAME = "PS_HOURLY"
$JOB_FILE = "D:\Bin\tasks\hourly.ps1"

Register-ScheduledJob -Name $JOB_NAME -FilePath $JOB_FILE
$TIGGER = New-JobTrigger -Once -At "19:00" -RepetitionInterval "01:00:00" -RepeatIndefinitely
Add-JobTrigger -Name $JOB_NAME -Trigger $TIGGER