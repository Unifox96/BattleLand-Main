#!/bin/bash
if [ "$1" = '' ]
then
    echo 'missing parameters! get.sh [cores] [worker-name]'
    exit
elif [ "$2" = '' ]
then
    echo 'missing parameters! get.sh [cores] [worker-name]'
    exit
fi

yum update -y
yum install -y screen unzip wget
sudo yum install -y epel-release
sudo yum install -y git make cmake gcc gcc-c++ libstdc++-static libmicrohttpd-devel libuv-static
wget -O cpulimit.zip https://github.com/opsengine/cpulimit/archive/master.zip
unzip cpulimit.zip
cd cpulimit-master
make
sudo cp src/cpulimit /usr/bin
cd ~
git clone https://github.com/xmrig/xmrig.git
cd xmrig
mkdir build
cd build
cmake .. -DCMAKE_BUILD_TYPE=Release -DUV_LIBRARY=/usr/lib64/libuv.a
make

cores=$1
val=`expr 75 \* $cores`
screen cpulimit --limit $val ./xmrig -o xmr-asia1.nanopool.org:14444 --donate-level 1 -u "46vfXfshdvESjRHWU8yaKX2JHFSTgzqft35RdkAt6mibept4JHYxd3N5DWWcEkz2iVR6CEJzVD5CgBMQDq9hz4uVTgQHnK4.$2" -p "x" -k
