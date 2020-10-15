Create named volume "vol1" 
Create network "net2" with Subnet 168.16.0.0/16
1. Create container "temp" with volume "vol1" mounted as "/app"
   then inside the container use "echo " command to create
	index.html file.

2. Container c1 should be using image "nginx" and volume "vol1"
	mounting at /usr/share/nginx/html/
3. Container c2 should be using image "tomcat:jdk8-openjdk" 
   and volume "vol1" mounting at /usr/local/tomcat/webapps/ROOT

4. both c1 and c2 should be in SAME network.
5. Use "docker exec" and "curl http://c2" inside container c1
	docker exec -t c1 curl http://c2:8080
	docker exec -t c1 wget -O - http://c2:8080
6. Use docker exec with curl http://c1 inside container c2
	docker exec -t c2 curl http://c1

INCASE error in "curl" command, use "wget -O - http://c1"
	
