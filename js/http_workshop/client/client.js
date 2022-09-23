// fetch("/api/hello")
//   .then((response) => {
//     return response.json();
//   })
//   .then((responseBody) => {
//     console.log("responseBody", responseBody);
//   });

document.querySelector("#my-form")?.addEventListener("submit", (e) => {
  e.preventDefault();

  const email = document.querySelector("#email");

  if (email) {
    const value = email.value;

    fetch(`/api/email?email=${encodeURIComponent(value)}`, {})
      .then((response) => {
        console.log(response.status);
        console.log("Email Successfully Saved");
      })
      .catch((error) => {
        console.log("Some error", error);
      });
  }
});
