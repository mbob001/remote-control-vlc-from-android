# Remote control VLC from Android
Remote control VLC application from Android device

The project includes two parts:
* Android project - control buttons, sending commands to service
* Python service - simple UDP listener to receive commands

## How it's works
When VLC is running on computer and then you push the button on Android device, such as Pause, Play... UDP packet is sended to PC where running python UDP listener. UDP listener recognize command and by the VLC parameters control current VLC application. Steps for commands backward and forward is set to 10 seconds.

## Initial setup
For connection between Android application nad scripts on computer is neccessary set IP adress and port of computer. For python script set these values in [control-service.py](https://github.com/mbob001/remote-control-vlc-from-android/blob/main/Service/control-service.py). For Android application set values in [sender.java](https://github.com/mbob001/remote-control-vlc-from-android/blob/main/Android/Remote4you/app/src/main/java/cz/soft4you/remote/Sender.java).

## Run projects
First run python scripts on computer. Then e.g. play video by VLC application. Run Android application on your device. Push one of three buttons Play, Bakward, Forward.

## Missing parts
* no authorization between Android application and python scripts on computer
* on computer scripts can run as service or daemon
* supported commands PLAY, PAUSE, BAKWARD, FORWARD - you can add other buttons and controls

