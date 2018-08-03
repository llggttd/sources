$JOB_NAME = "Update Networx"
$JOB_FILE = "D:\Bin\task-update-networx.ps1"

Register-ScheduledJob -Name $JOB_NAME -FilePath $JOB_FILE
$TIGGER = New-JobTrigger -Once -At "20:00" -RepetitionInterval "00:01:00" -RepeatIndefinitely
Add-JobTrigger -Name $JOB_NAME -Trigger $TIGGER