import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav
      style={{
        padding: "20px 40px",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",

        background: "rgba(255,255,255,0.03)",
        backdropFilter: "blur(16px)",
        WebkitBackdropFilter: "blur(16px)",

        borderBottom: "1px solid rgba(255,255,255,0.08)",

        // position: "sticky",
        top: 0,
        zIndex: 1000
      }}
    >
      <div style={{ textAlign: "center" }}>
        <h1
          style={{
            margin: 0,
            fontSize: "42px",
            fontWeight: "800",

            background:
              "linear-gradient(90deg,#60a5fa,#8b5cf6)",

            WebkitBackgroundClip: "text",
            WebkitTextFillColor: "transparent"
          }}
        >
          Coding Platform
        </h1>

        <p
          style={{
            margin: "8px 0 0 0",
            color: "#94a3b8",
            fontSize: "18px"
          }}
        >
          Practice Coding. Detect Panic. Recover Faster.
        </p>
      </div>


<div
  style={{
    position: "absolute",
    right: "40px",
    display: "flex",
    gap: "12px"
  }}
>
  <Link
    to="/"
    style={{
      padding: "10px 18px",
      borderRadius: "999px",
      background: "rgba(255,255,255,0.06)",
      border: "1px solid rgba(255,255,255,0.08)",
      backdropFilter: "blur(10px)",
      color: "#e2e8f0",
      fontWeight: "600",
      transition: "all .2s ease"
    }}
  >
    Problems
  </Link>

  <Link
    to="/submissions"
    style={{
      padding: "10px 18px",
      borderRadius: "999px",
      background: "rgba(255,255,255,0.06)",
      border: "1px solid rgba(255,255,255,0.08)",
      backdropFilter: "blur(10px)",
      color: "#e2e8f0",
      fontWeight: "600",
      transition: "all .2s ease"
    }}
  >
     Submissions
  </Link>
</div>
    </nav>
  );
}

export default Navbar;