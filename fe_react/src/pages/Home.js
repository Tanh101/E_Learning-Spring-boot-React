import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../components/Card/Card";
import MultiCard from "../components/MultiCard/MultiCard";

function Home() {
  return (
    <div>
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
