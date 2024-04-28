import React, { useState } from 'react';
import usePokemons from '../hooks/usePokemons';

const HomePage = ({money, setMoney}) => {
    const [clicked, setClicked] = useState(false);
    const { pokemons } = usePokemons();
    
    const handleClick = () => {
      const randomMoney = Math.floor(Math.random() * 5) + 1;
      setMoney(prevMoney => prevMoney + randomMoney);
      setClicked(true);

      setTimeout(() => {
        setClicked(false);
      }, 75);
    };

  return (
    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', height: '70vh' }}>
      <div style={{ position: 'fixed', top: '10%', left: '50%', transform: 'translateX(-50%)', textAlign: 'center' }}>
        <h1>Home Page</h1>
        <p>Welcome to the Home Page!</p>
      </div>
      <div style={{ marginTop: "120px" }}>
        <img
          src="https://64.media.tumblr.com/c3f6563dc4cbbf9fa5cbdc6c85346529/tumblr_inline_pab3jajU1d1qapklj_500.png"
          alt="Click Me"
          style={{
            cursor: 'pointer',
            width: clicked ? '310px' : '300px',
            height: clicked ? '310px' : '300px',
            transition: 'all 0.1s ease-in-out',
          }}
          onClick={handleClick}
        />
      </div>
      <p>Money: {money}</p>
    </div>
  );
}

export default HomePage;
