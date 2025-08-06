#!/bin/bash

echo "Reiniciando aplicación..."

# Mover el nuevo JAR desde deploy a app
mv ~/deploy/*.jar ~/app/

# Detener procesos anteriores
pkill -f 'java -jar' || true
sleep 2

# Ejecutar nuevo JAR
nohup java -jar ~/app/*.jar > ~/app/log.txt 2>&1 &

echo "App desplegada correctamente"
