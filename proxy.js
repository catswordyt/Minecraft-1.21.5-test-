import net from 'net';
import { WebSocketServer } from 'ws';

const WSS_PORT = 8081, MC_HOST = 'your.mc.server', MC_PORT = 25565;
const wss = new WebSocketServer({ port: WSS_PORT });

wss.on('connection', ws => {
  const mcs = net.connect(MC_PORT, MC_HOST);
  mcs.on('data', b => ws.send(b));
  ws.on('message', b => mcs.write(b));
  const close = () => { mcs.destroy(); ws.terminate(); };
  ws.on('close', close); mcs.on('error', close);
});

console.log(`Proxy listening on ws://localhost:${WSS_PORT}`);