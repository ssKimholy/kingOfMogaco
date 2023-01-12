import React, {useState} from "react";

 

const MyButton = ({incrementer}) => {

    

    const [currentCount, setCurrentCount] = useState(0);

 

    const handleClick = () => {

        setCurrentCount(currentCount+incrementer);

    }

 

    return (

        <div>

            <button onClick={handleClick}>+{incrementer}</button>

            <div>{currentCount}</div>

        </div>

    );
}

export default MyButton;
