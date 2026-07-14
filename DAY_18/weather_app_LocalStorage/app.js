const cityName = document.getElementById("cityName");

const getWeatherBtn = document.getElementById("getWeatherBtn");

const weatherInfo = document.getElementById("weatherInfo");


getWeatherBtn.addEventListener("click", async () => {
    let input = cityName.value.trim();
    if (input === "") {
        alert("Enter city name to see your weather data!");
        return;
    }

    weatherInfo.innerHTML = `<h3>Loading...</h3>`;


    const url = `https://wttr.in/${input}?format=j1`;

    const response = await fetch(url);
    const data = await response.json();

    console.log(data.current_condition[0]);
    
    let weather = data.current_condition[0];

    weatherInfo.innerHTML = `<h2>City: ${input}</h2>
    <p>Temperature: ${weather.temp_C}</p>
    <p>Humidity: ${weather.humidity}</p>
    <p>Feels Like: ${weather.FeelsLikeC}</p>
    <p>Wind Speed Kmph: ${weather.windspeedKmph}</p>
    <p>Weather Desc: ${weather.weatherDesc[0].value}</p>`


    cityName.value = "";
    cityName.focus();
});