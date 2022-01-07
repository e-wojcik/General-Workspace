Set-ExecutionPolicy Unrestricted
Get-ScheduledTask -TaskName "Prevent Responder Attack" | Unregister-ScheduledTask -Confirm:$false
$action = New-ScheduledTaskAction -Execute 'Powershell.exe'-Argument '-NoProfile -WindowStyle Hidden -command "& 
{
@echo off

REG DELETE "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\Wpad" /f
REG DELETE  "HKLM\Software\policies\Microsoft\Windows NT\DNSClient" /f
REG DELETE  "HKLM\SYSTEM\CurrentControlSet\Services\Dnscache\Parameters" /f

REG ADD "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\Wpad"
REG ADD "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\Wpad" /v "WpadOverride" /t REG_DWORD /d "1" /f


REG ADD  "HKLM\Software\policies\Microsoft\Windows NT\DNSClient"
REG ADD  "HKLM\Software\policies\Microsoft\Windows NT\DNSClient" /v "EnableMulticast" /t REG_DWORD /d "0" /f
REG ADD  "HKLM\Software\policies\Microsoft\Windows NT\DNSClient" /v "DisableSmartNameResolution" /t REG_DWORD /d "1" /f
REG ADD  "HKLM\SYSTEM\CurrentControlSet\Services\Dnscache\Parameters"
REG ADD  "HKLM\SYSTEM\CurrentControlSet\Services\Dnscache\Parameters" /v "DisableParallelAandAAAA" /t REG_DWORD /d "1" /f
}"'

$trigger =  New-ScheduledTaskTrigger -AtStartup

Register-ScheduledTask -Action $action -Trigger $trigger -TaskName "Prevent Responder Attack" -Description "(WPAD & LLMNR)"
Set-ExecutionPolicy Restricted