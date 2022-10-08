import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../components/Card/Card";
import MultiCard from "../components/MultiCard/MultiCard";
import image from "../images/background-home.jpg";
function Home() {
  useEffect(() => {
    document.querySelector(".navbar").classList.add("mask-custom");
    const handleScroll = (event) => {
      if (window.scrollY > 60) {
        document.querySelector(".navbar").classList.remove("mask-custom");
      } else {
        document.querySelector(".navbar").classList.add("mask-custom");
      }
    };

    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  });
  return (
    <div>
      <section>
        <div
          id="intro"
          className="bg-image vh-100"
          style={{
            backgroundImage: `url(${image})`,
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        >
          <div
            className="mask"
            style={{ backgroundColor: "rgba(250, 182, 162, 0.15)" }}
          ></div>
        </div>
      </section>
      <div className="jumbotron jumbotron-fluid">
        <div className="container">
          <h1 className="text-center fw-bold display-1 mb-5">
            Famous <span className="text-danger">Lesson</span>
          </h1>
        </div>
      </div>

      <MultiCard />
    </div>
  );
}

export default Home;
