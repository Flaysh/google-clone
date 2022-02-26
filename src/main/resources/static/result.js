/*Google Clone Application - JS file, for fetching the data from our JAVA backend to our static HTML pages.
 * Front fetching data and appending it to the UI.
 * Built with Java & Spring Boot Library
 * Written by Itay Flaysher - Software engineer
 * 26/02/2022
 * */

//starting a jQuery function
$(document).ready(function () {
  //Getting the params that i sent from the home page
  let searchParams = new URLSearchParams(window.location.search);
  searchParams.has("query");
  let param = searchParams.get("query");

  //decoding the params to show it nicely to the user
  $("#input-field").val(decodeURIComponent(param.replace(/\+/g, " ")));

  //this is a fetch function. here i get data from the JAVA REST API
  function getResults() {
    //encoding the param for the backend to recive correctly
    let encodedParam = encodeURIComponent(param.replace(/ /g, "+"));
    let search_options = {
      type: "GET",
      url: "http://localhost:8080/search?query=" + encodedParam,
    };
    $.ajax(search_options)
      .done(function (response) {
        //dissapearing the loader
        $(".loader").hide();
        //presenting data to UI
        appendData(response.results);
        //getting previous searches from API
        getPreviousSearches(encodedParam);
      })
      .fail(function (xhr, textStatus, errorThrown) {
        alert("failed");
      });
  }

  //UI Function, showing the user the results.
  function appendData(data) {
    for (var i = 0; i < data.length; i++) {
      var div = document.createElement("div");
      div.classList.add("result");
      div.innerHTML = `<h2><a href=${data[i].link}>${data[i].title}</a></h2><a class="link" href=${data[i].link}>${data[i].link}</a><p><span>Feb 27, 2022 - </span>${data[i].description}</p>`;
      $(".searchResults").append(div);
    }
  }
  //fetch function, getting from JAVA rest API the previous searches of the current user
  function getPreviousSearches(param) {
    let search_options = {
      type: "GET",
      url: "http://localhost:8080/previous?query=" + param,
    };
    $.ajax(search_options)
      .done(function (response) {
        //append to UI
        appendPreviousSearch(response);
      })
      .fail(function (xhr, textStatus, errorThrown) {
        alert("failed");
      });
  }

  // Append fetched data from JAVA REST API to user.
  function appendPreviousSearch(data) {
    $(".previous-searches").append(`<p class="ps">Previous Searches: `);
    //running on the data and gets only the one with query
    data.forEach((psObject) => {
      if (psObject.query) {
        $(".previous-searches").append(
          `<a href=${
            "result?query=" + psObject.query
          } class="ps-link">${psObject.query.replace(/\+/g, " ")}, `
        );
      }
    });
    $(".previous-searches").append(`</span></p>`);
  }
  //Initial call to get the first results
  getResults();

  //start a next search from the result page. -> redirect the user to another Result page.
  $("#input-field").on("keypress", function (e) {
    if (e.which == 13) {
      window.location.replace(
        "result?query=" +
          encodeURIComponent($("#input-field").val().replace(/ /g, "+"))
      );
    }
  });
});
