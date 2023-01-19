sudo chmod +x ipcalculator.jar
sudo mv ipcalculator.jar /usr/local/bin/ipcalculator.jar
echo "#!/bin/bash" > ipcalculator.sh
echo "java -jar /usr/local/bin/ipcalculator.jar" >> ipcalculator.sh
sudo mv ipcalculator.sh /usr/local/bin/ipcalculator
sudo chmod +x /usr/local/bin/ipcalculator