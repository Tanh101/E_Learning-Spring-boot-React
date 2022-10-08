import { useEffect, useState } from "react";
import "./CardKanji.css";

function CardKanji({ props }) {
  const [change, setChange] = useState(true);
  const handleChange = (e) => {
    if (change) {
      document.getElementsByClassName(
        `flip-card-inner ${props.id}`
      )[0].style.cssText = "transform: rotateX(180deg);";
      setChange(false);
    } else {
      document.getElementsByClassName(
        `flip-card-inner ${props.id}`
      )[0].style.cssText = "transform: 0";
      setChange(true);
    }
  };
  return (
    <div className="wrapper">
      <div className="flip-card" onClick={handleChange}>
        <div className={`flip-card-inner ${props.id}`}>
          <div className="flip-card-front">
            <div className="title">{props.text}</div>
          </div>
          <div className="flip-card-back">
            {props.image ? (
              <img
                src={props.image}
                className="rounded mx-auto d-block"
                alt="..."
                style={{
                  width: "200px",
                  margin: "20px",
                }}
              />
            ) : (
              <></>
            )}

            <div className="card-body">
              <h5 className="title">{props.mean}</h5>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CardKanji;
