redis-server /conf/redis.conf --port 7000 --cluster-config-file /conf/nodes.7000.conf --daemonize yes ;
redis-server /conf/redis.conf --port 7001 --cluster-config-file /conf/nodes.7001.conf --daemonize yes ;
redis-server /conf/redis.conf --port 7002 --cluster-config-file /conf/nodes.7002.conf --daemonize yes ;
redis-server /conf/redis.conf --port 7003 --cluster-config-file /conf/nodes.7003.conf --daemonize yes ;
redis-server /conf/redis.conf --port 7004 --cluster-config-file /conf/nodes.7004.conf --daemonize yes ;
redis-server /conf/redis.conf --port 7005 --cluster-config-file /conf/nodes.7005.conf --daemonize yes ;


redis-cli -p 7000 info 1> /conf/r7000i.log 2> /dev/null;
redis-cli -p 7001 info 1> /conf/r7001i.log 2> /dev/null;
redis-cli -p 7002 info 1> /conf/r7002i.log 2> /dev/null;
redis-cli -p 7003 info 1> /conf/r7003i.log 2> /dev/null;
redis-cli -p 7004 info 1> /conf/r7004i.log 2> /dev/null;
redis-cli -p 7005 info 1> /conf/r7005i.log 2> /dev/null;


yes "yes" | redis-cli --cluster create 172.16.239.10:7000 172.16.239.10:7001 172.16.239.10:7002 172.16.239.10:7003 172.16.239.10:7004 172.16.239.10:7005 --cluster-replicas 1;
