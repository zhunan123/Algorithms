import { useState, useEffect } from "react";
import axios from "axios";
import './NewsStyle.css';

const API_KEY = "48269f1d29894484b566c06f94eb489f";

const NewsComponent = () => {
  // set new state
  const [newsPage, setNewsPage] = useState([]);
  // call useEffect to to fetch news before page loads
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `https://newsapi.org/v2/top-headlines?country=us&apiKey=${API_KEY}`
        );
        console.log(response);
        // setNewPage response
        setNewsPage(response.data.articles);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, []);

  // add onclick function to open up actual article
  const handleClick = (url) => {
    window.open(url, "_blank");
  }

  return (
    <div className="news-container">
      {newsPage.map((article, index) => (
        <div key={index} className="article">
            <h2>{article.title}</h2>
            <p className="article-author">Author: {article.author}</p>
            <p>{article.description}</p>
            <div className="learn-more-detail">
              <button onClick={() => handleClick(article.url)}>
                Learn more {">>"}
            </button>
            </div>
            {article.urlToImage && (
                <img src={article.urlToImage} alt={article.title} />
            )}
        </div>
      ))}
    </div>
  );
};

export default NewsComponent;
