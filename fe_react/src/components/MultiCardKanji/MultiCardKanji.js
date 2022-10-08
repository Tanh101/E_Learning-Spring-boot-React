import { useEffect, useState } from "react";
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import CardKanji from "../CardKanji/CardKanji";
import API from "../../requestHttp";
import "./MultiCardKanji.css";
import { async } from "@firebase/util";
const responsive = {
  desktop: { breakpoint: { max: 3000, min: 1024 }, items: 1 },
  mobile: { breakpoint: { max: 464, min: 0 }, items: 1 },
  tablet: { breakpoint: { max: 1024, min: 464 }, items: 1 },
};
function MultiCardKaji() {
  const [listKanji, setListKanji] = useState([]);
  const [current, setCurrent] = useState(1);
  const [total, setTotal] = useState();
  useEffect(() => {
    API.get("cardKanjis").then((res) => {
      setListKanji(res.data);
      setTotal(res.data.length);
    });
  }, []);
  function CustomLeftArrow({ onClick }) {
    function handleClick() {
      onClick();
      if (current > 1) {
        setCurrent(current - 1);
      }
    }

    return (
      <button
        onClick={handleClick}
        aria-label="Go to next slide"
        className="react-multiple-carousel__arrow react-multiple-carousel__arrow--left"
      />
    );
  }
  function CustomRightArrow({ onClick }) {
    function handleClick() {
      onClick();
      if (current < total) {
        setCurrent(current + 1);
      }
    }

    return (
      <button
        onClick={handleClick}
        aria-label="Go to next slide"
        className="react-multiple-carousel__arrow react-multiple-carousel__arrow--right"
      />
    );
  }
  const renderCard = () => {
    return listKanji.map((item, index) => {
      return (
        <div key={index} className="item">
          <CardKanji props={item} />
        </div>
      );
    });
  };
  return (
    <div className="wrapper-card">
      <Carousel
        partialVisbile
        // deviceType={deviceType}
        itemClass="image-item"
        responsive={responsive}
        removeArrowOnDeviceType={["tablet", "mobile"]}
        customRightArrow={<CustomRightArrow />}
        customLeftArrow={<CustomLeftArrow />}
      >
        {renderCard()}
      </Carousel>
      <div className="numbers">
        {current}/{total}
      </div>
    </div>
  );
}

export default MultiCardKaji;
