import socket
import subprocess

UDP_IP = "10.0.0.11"
UDP_PORT = 1866

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((UDP_IP, UDP_PORT))
 
while True:
    data, addr = sock.recvfrom(1024) # buffer size is 1024 bytes
    print("received message: %s" % data)
    
    if "play-pause" in data.decode("utf-8"):
        subprocess.call(("playerctl", "play-pause"))
    
    if "forward" in  data.decode("utf-8"):
        subprocess.run(["playerctl", "--player=vlc", "position", "10+"])
        
    if "backward" in  data.decode("utf-8"):
        subprocess.run(["playerctl", "--player=vlc", "position", "10-"])
