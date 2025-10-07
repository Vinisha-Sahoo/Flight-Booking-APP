alert("script loaded!");
// --- MODAL OPEN/CLOSE LOGIC ---

// Show Sign In Modal
document.querySelector("#openSignIn")?.addEventListener("click", () => {
  document.getElementById("signInModal").style.display = "block";
});

// Show Sign Up Modal from link
document.querySelector("#toSignUp")?.addEventListener("click", (e) => {
  e.preventDefault();
  document.getElementById("signInModal").style.display = "none";
  document.getElementById("signUpModal").style.display = "block";
});

// Show Sign In Modal from link in Sign Up
document.querySelector("#toSignIn")?.addEventListener("click", (e) => {
  e.preventDefault();
  document.getElementById("signUpModal").style.display = "none";
  document.getElementById("signInModal").style.display = "block";
});

// Close modals when clicking outside the modal content
window.onclick = function(event) {
  if (event.target.classList.contains("modal")) {
    event.target.style.display = "none";
  }
};

// Close buttons inside modals
document.querySelector("#closeSignIn")?.addEventListener("click", function() {
  document.getElementById("signInModal").style.display = "none";
});
document.querySelector("#closeSignUp")?.addEventListener("click", function() {
  document.getElementById("signUpModal").style.display = "none";
});

// --- SIGN UP FORM HANDLER ---
document.querySelector("#signUpModal form")?.addEventListener("submit", async (e) => {
  e.preventDefault();
  const fullName = e.target[0].value;
  const email = e.target[1].value;
  const phone = e.target[2].value;
  const password = e.target[3].value;

  const res = await fetch("http://10.3.50.43:8082/signup", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ fullName, email, phone, password }),
  });

  const data = await res.json();
  if (res.ok) {
    localStorage.setItem("userName", data.user.fullName);
    window.location.href = "passenger.html";
  } else {
    alert(data.message);
  }
});

// --- SIGN IN FORM HANDLER ---
document.querySelector("#signInModal form")?.addEventListener("submit", async (e) => {
  e.preventDefault();
  const email = e.target[0].value;
  const password = e.target[1].value;

  const res = await fetch("http://10.3.50.43:8082/signin", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
  });

  const data = await res.json();
  if (res.ok) {
    localStorage.setItem("userName", data.user.fullName);
    window.location.href = "passenger.html";
  } else {
    alert(data.message);
  }
});