# Minecraft Java → WebAssembly (1.21.5)

**Live demo**: https://<your‑username>.github.io/minecraft-java-web/

## Setup

1. Clone:
   ```bash
   git clone https://github.com/<you>/minecraft-java-web.git
   cd minecraft-java-web
   ```
2. Install deps & build:
   ```bash
   mvn clean package
   ```
   This generates `docs/minecraft.js` & `docs/minecraft.wasm`.

3. Copy a valid 1.21.5 `assets/` folder into `src/main/resources/assets/`.

4. Push to GitHub:
   ```bash
   git add .
   git commit -m "Init WASM port"
   git push
   ```
5. In your repo’s **Settings → Pages**, choose the `docs/` folder as source.
6. Browse to `https://<you>.github.io/minecraft-java-web/`.

## Running the proxy

```bash
npm install ws
node proxy.js
```

Connect your browser client (built above) to  
`wss://<your‑host>:8081` → your real Java server.

---

You’ll now have a zero‑download, browser‑only Minecraft client for 1.21.5—all served straight from GitHub Pages!