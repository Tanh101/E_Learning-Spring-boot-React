import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../components/Card/Card";
import MultiCard from "../components/MultiCard/MultiCard";

function Home() {
  useEffect(() => {
    document.querySelector('.navbar').classList.add('mask-custom');
    const handleScroll = event => {
      if (window.scrollY > 60) {
        document.querySelector('.navbar').classList.remove('mask-custom');
      }
      else {
        document.querySelector('.navbar').classList.add('mask-custom');
      }
    };

    window.addEventListener('scroll', handleScroll);

    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  });
  return (
    <div>
      <div className="jumbotron jumbotron-fluid">
        <div className="container">
          <h1 class="text-center fw-bold display-1 mb-5">
            Famous <span class="text-danger">Lesson</span>
          </h1>
        </div>
      </div>

      <MultiCard />
    </div>
  );
}

export default Home;
