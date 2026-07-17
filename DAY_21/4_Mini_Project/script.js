

const rawUserPayload = {
    name: "Jagan",
    email: "Jmr@gmail.com",
    phone: null,
    address: {
        city: "Coimbatore"
    }
};

const visibleProfile = {
    "Name" : rawUserPayload?.name ?? "Not Applicable",
    "Email" : rawUserPayload?.email ?? "Not Applicable",
    "Phone" : rawUserPayload?.phone ?? "Not Applicable",
    "Company" : rawUserPayload?.company?.name ?? "Not Applicable",
    "City" : rawUserPayload?.address?.city ?? "Not Applicable",
};


const container = document.getElementById("profile-container");
Object.entries(visibleProfile).forEach(([label, value])=>{
    const row = document.createElement("div");
    row.className = "profile-row";

    row.innerHTML = `
    <p class="label">${label}:</p>
    <p class="value">${value}</p>
    `;

    container.appendChild(row);
});