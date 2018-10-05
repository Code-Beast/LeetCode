# HW 1: Networking fundamentals
### 1.3
* (a) Because the packet can be sent continuously and $Transmit = Size / Bandwidth$,
$$\begin{eqnarray} 
transmitTime&=&totalSize\div bandwidth\nonumber\\
&=&1000KB\div 1.5Mbps\nonumber\\
&\approx&5.333s\nonumber
\end{eqnarray}$$
	
	Thus, we can get,
$$\begin{eqnarray}
totalTime&=&handshakingTime+RTT/2+transmitTime\nonumber\\
&=&2\times RTT+RTT\div2+transmitTime\nonumber\\
&=&2\times50ms+50ms/2+5.33s\nonumber\\
&\approx&5.458s\nonumber
\end{eqnarray}$$
* (b) Because after we finish sending each packet we have to wait one RTT for sending next one, and the number of packets to send is,
$$numOfPackets=totalSize\div packetSize=1000$$
	
	The transmit time without the waiting time from (a) is 5.333s, thus,
$$\begin{eqnarray}
totalTime&=&handshakingTime+RTT/2+transmitTime+waitingTime\nonumber\\
&=&2\times50ms+50ms/2+5.33s+50ms*(numOfPackets-1)\nonumber\\
&\approx&55.408s\nonumber
\end{eqnarray}$$
* (c) Because 20 packets can be sent per RTT (which means we have to wait one RTT for sending the next 20 packets) and the total number of packets to send is 1000, it takes $(1000-20)\div20=49$ RTT to send the whole file. Given $transmitTime=0$,
$$\begin{eqnarray}
totalTime&=&handshakingTime+RTT/2+transmitTime+49\times RTT\nonumber\\
&=&2\times50ms+50ms/2+0+49\times50ms\nonumber\\
&=&2.575s\nonumber
\end{eqnarray}$$
* (d) Because during the $k_{th}$ RTT, we can send $2^{k-1}$ packets, the total number of RTTs we need to send the whole file is the smallest integer n that conforms to $2^{0}+2^{1}+2^{2}+...2^n\ge1000$. Since we know $2^0+2^1+2^2+...2^{n+1}=2^{n+1}-1$, we can get $n=9$ and
$$\begin{eqnarray}
totalTime&=&handshakingTime+RTT/2+transmitTime+9\times RTT\nonumber\\
&=&2\times50ms+50ms/2+0+9\times50ms\nonumber\\
&=&0.575s\nonumber
\end{eqnarray}$$

#### 1.5
* (a) From the problem, we know
$$\begin{eqnarray}
propagationDelay&=&distance/speedOfLight\nonumber\\
&=&4km\div(2\times10^8m/s)\nonumber\\
&=&20\mu s\nonumber
\end{eqnarray}$$
	
	So, for 100-byte packets, let $transmitDelay=propagationDelay$, we can get,
$$\begin{eqnarray}
bandwidth&=&size/transmitDelay\nonumber\\
&=&100byte/20\mu s\nonumber\\
&=&40Mbps\nonumber
\end{eqnarray}$$

	And for 512-byte packtes,
$$\begin{eqnarray}
bandwidth&=&size/transmitDelay\nonumber\\
&=&512byte/20\mu s\nonumber\\
&=&204.8Mbps\nonumber
\end{eqnarray}$$

#### 1.13
* (a) $$\begin{eqnarray}
			RTT&=&2\times distance\div speedOfLight\nonumber\\
			&=&2\times385000km\div(3\times10^8m/s)\nonumber\\
			&=&2.567s\nonumber
			\end{eqnarray}$$
* (b) $$\begin{eqnarray}
			delay\times bandwidth\;product&=&RTT\times bandwidth\nonumber\\
			&=&2.567s\times1Gbps\nonumber\\
			&=&2.567Gb\nonumber\\
			&=&2.567\div8GB\nonumber\\
			&\approx&320.88MB\nonumber
			\end{eqnarray}$$
* (c) One-way dalay $\times$ bandwidth product is important because it corresponds to how many bits the sender must transmit before the first bit arrives at the receiver; RTT delay $\times$ bandwidth product's significance is that it responds to how any bits the sender must transmit before it get back the response to the first bit from the receiver.
* (d) Because the request for the data has gone out, we don't need to count the transmit time for that, which means that total time is the propagation time for the request plus the transmit time for the data plus the propagation time for the data, in other words,
$$\begin{eqnarray}
minimumTime&=&transmitTimeForData+RTT\nonumber\\
&=&25MB/1Gbps+2.567s\nonumber\\
&=&2.767s\nonumber
\end{eqnarray}$$

#### 1.20
* (a) Because the 10,000 bits are sent as a single packet, so the transmit time at A is the same as the transmit time at the switch, that is,
$$\begin{eqnarray}
transmitTime&=&size/bandwidth\nonumber\\
&=&10000bit/100Mbps\nonumber\\
&=&100\mu s\nonumber
\end{eqnarray}$$

	Thus,
$$\begin{eqnarray}
totalTime&=&transmitTime\times2+propagationTime+switchStoreTime\nonumber\\
&=&100\mu s\times2+20\mu s\times2+35\mu s\nonumber\\
&=&275\mu s\nonumber
\end{eqnarray}$$

* (b) It takes $propagationTime+5000bits/100Mbps=70\mu s$ for the first 5,000-bit packet to arrive at the switch. Thus it takes $5000bits/100Mbps=50\mu s$ more for the second 5,000bit packet to arrive at the switch, which is longer than the waiting time ($35\mu s$) for the first packet to be sent out<br> from the switch.

	Thus (we denote the first packet as p1, the second packet as p2), we can say that: at $0\mu s$, p1 is sent out from A; at $50\mu s$, p2 is sent out from A; at $70\mu s$, p1 reaches the middle switch; at $70\mu s+35\mu s=105\mu s$, p1 is sent out from the switch; at $70\mu s+50\mu s=120\mu s$, p2 reaches the middle switch; at $120\mu s+35\mu s=155\mu s$, p2 is sent out from the switch; at $105\mu s+70\mu s=175\mu s$, p1 reaches B; at $155\mu s+70\mu s=225\mu s$, p2 reaches B.

	To sum up, $totalTime=225\mu s$
	
#### 1.22
For a 1000-byte packet, $totalNumber=1MB/1000byte\times50byte+1000byte=51000byte$;

For a 10000-byte packet, $totalNubmer=1MB/10000byte\times50byte+10000byte=15000byte$;
	
For a 20000-byte packet, $totalNumber=1MB/20000byte\times50byte+20000byte=22500byte$;
	
Thus, the optimal packet size is 10,000 bytes.

#### 1.23
For the sake of clarity, first we extract the key information from the problem:

$$
totalSize=nB\\
numOfLinks=7\\
numOfSwitches=5\\
linkPropagationTime=2ms\\
linkBandwidth=4Mbps\\
$$

For packet switching,
$$
payloadSize=1KB=8Kb\\
packetHeaderSize=24B=192b\\
packetSize=payloadSize+packetSize\\
switchDelay=1ms\\
$$

For circuit switching:
$$
\begin{eqnarray}
setupMessageSize&=&1KB=8Kb,\nonumber\\
setupTime&=&2\times(setupMessageSize+packetHeaderSize)/bandwidth+2\times numOfSwitches\times\nonumber\\
&&switchDelayTime+2\times numOfLinks\times linkPropagationTime+2\times\nonumber\\
&&numOfSwitches\times(setupMessageSize+packetHeaderSize)\div bandwidth\nonumber\\
&=&62.576ms\nonumber
\end{eqnarray}
$$

* (a) For circuit switching, 
$$\begin{eqnarray}
totalNumOfBytes1&=&totalSize+setupMessageSize\times2\nonumber\\
&=&nB+1KB\times2\nonumber\\
&=&(n+2000)B\nonumber
\end{eqnarray}$$

	For packet switching,
$$\begin{eqnarray}
totalNumOfBytes2&=&totalSize+totalSizeB/payloadSize\times packetHeaderSize\nonumber\\
&=&nB+nB/1KB\times24B\nonumber\\
&=&(n+24n/1000)B\nonumber
\end{eqnarray}$$


	If these two numbers are the same, 
$$(n+24n/1000)B>(n+2000)B\\n>83333$$
	Thus the filesize nB shoulb be larger than 83,333 bytes.
	
* (b) For circuit switching,
$$\begin{eqnarray} 
setupTime&=&62.576ms,\nonumber\\
propagatioinTime1&=&numOfLinks\times linkPropagationTime\nonumber\nonumber\\
&=&14ms,\nonumber\\ 
transmitTime1&=&totalSize\div bandwidth\nonumber\\
&=&nB/4Mbps\nonumber\\
&=&0.002nms\nonumber
\end{eqnarray}$$

	Thus, the total latency for circuit switching is:
$$\begin{eqnarray} 
totalLatency1&=&setupTime+propagatioinTime1+transmitTime1\nonumber\\
&=&(76.576+0.002n)ms\nonumber
\end{eqnarray}$$
	
	For packet switching,
$$\begin{eqnarray} 
propagationTime2&=&numOfLinks\times linkPropagationTime\nonumber\nonumber\\
&=&14ms\nonumber\\ 
transmitTime2&=&sourceTransmitTime+switchesTransmitTime\nonumber\\
&=&totalNumOfBytes2\div bandwidth+numOfSwitches\nonumber\\
&&\times packetSize\div bandwidth\nonumber\\
&=&(n+24n/1000)B\div 4Mbps+5\times(payloadSize+packetHeaderSize)\nonumber\\
&&\div 4Mbps\nonumber\\
&=&(0.002048n+10.24)ms\nonumber\\
totalSwitchDelayTime&=&numOfSwitches\times switchDelayTime\nonumber\\
&=&5ms\nonumber
\end{eqnarray}$$

	Thus the total latency for packet switching is:
$$\begin{eqnarray} 
totalLatency2&=&propagationTime2+transmitTime2+totalSwitchDelayTime\nonumber\\
&=&(29.24ms+0.002048n)ms\nonumber
\end{eqnarray}$$

	To make sure $totalLatency1 < totalLatency2$,
$$76.576+0.002n < 29.24+0.002048n\\
n > 986167$$

	So the filesize nB should be larger than 986,167 bytes.

* (c) Let's consider the following conditions:
	For (a), the equations for totalNumOfBytes1 and totalNumOfBytes2 don't involve the number of switches and the bandwidth, so we can say the result is not sensitive to these two factors at all. Also, we can derive from the inequality that,
$$2000B<nB\div payloadSize\times packetHeaderSize\\n>payloadSize\div packetHeaderSize\times2000$$

	Thus, the result of (a)is sensitive to the ratio of packet size to packet header size.
	
	For (b), we set up three conditions:
	
	* (1) We don't replace numOfSwitches with the value in the calculations, then we can get,
	$$46.096+6.096\times numOfSwitches+0.002n<3.048\times numOfSwitches+14+0.002048n\\n>668667+63500\times numOfSwitches$$
		Thus the result of (b) is not sensitive to the number of switches.
	* (2) We don't replace bandwidth with the value in the calculations, then we can get,
	$$\frac{(n+12288)B}{bandwidth}+52ms<\frac{(1.024n+5120)B}{bandwith}+19ms\\n>1.375s/B\times bandwidth+298667$$
		Thus the result of (b) is not sensitive to the bandwidth.
	* (3) We don't replace bandwidth with the value in the calculations, then we can get,
	$$\frac{(payloadSize+packetHeaderSize)\times(12-5)}{4Mbps}+(52-19)ms<\\(0.002\times packetHeaderSize\div payloadSize)nms$$
		We assume the ratio of packet size to packet header size is R, and we replace the packedHeaderSize with its value, then we can get the inequality:
	$$n>16668R+168R^2$$
	
		From this we can say, the result of (b) is very sensitive to the ratio of packet size to packet header size.
	* (4) I think this model is not very accurate, because it is based on the assumption that this path is used only for the transferring of this nB file, but in realistic situations, there may be other files being transferred in this path at the same time.

