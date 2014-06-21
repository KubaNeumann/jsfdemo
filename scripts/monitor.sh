#!/bin/bash
#Script looks for changes in src folder and invokes rebuild/deployment script when necessary
BREAK_TIME=3
REBUILD_SCRIPT=scripts/buildRedeploy.sh
WATCHED_DIR=src

function get_latest_file_timestamp
{
	find $WATCHED_DIR -printf "%T@\n" | sort | tail -n 1
}

while [ 1 ] 
do
	current_date=`get_latest_file_timestamp` 
	if [ "$current_date" != "$old_date" ] ; then
		echo 'Filesystem changed, invoking rebuild script'
		old_date=$current_date
		$REBUILD_SCRIPT
	fi
	sleep $BREAK_TIME 
done
