
import * as React from 'react';

export default function KmToMiles() {
  const [amount, setAmount] = React.useState(0);
  const [flipped, setFlipped] = React.useState(false);
  const onChange = (event) => {
    setAmount(event.target.value);
  };
  const onClickReset = () => {
    setAmount(0);
  };
  const onClickFlip = () => {
    onClickReset();
    setFlipped((current) => !current);
  };
  return (
    <div>
      <div>
        <label htmlFor="kilo">Killometer</label>
        <input
          id="kilo"
          placeholder="killometer"
          type="number"
          value={flipped ? amount * 1.609 : amount}
          onChange={onChange}
          disabled={flipped}
        />
      </div>
      <div>
        <label htmlFor="miles">Miles</label>
        <input
          id="miles"
          placeholder="Miles"
          type="number"
          value={flipped ? amount : Math.round(amount / 1.609)}
          onChange={onChange}
          disabled={!flipped}
        />
      </div>
      <button onClick={onClickReset}>Reset</button>
      <button onClick={onClickFlip}>
        {flipped ? 'miles to killo' : 'killo to miles'}
      </button>
    </div>
  );
}
