import react, {useState} from 'react';

const SumComponent = () => {

    const [number1, setNumber1] = useState('')   // the initial states of the numbers are blank as they will be input
    const [number2, setNumber2] = useState('')
    const [sum, setSum] = useState(null);  // initial state will be null as state will be changed only on calculation

    const handleNumber1Change = (e) => {
        setNumber1(e.target.value);
    }

    const handleNumber2Change = (e) => {
        setNumber2(e.target.value);
    }

    const handleSum = (e) => {
        e.preventDefault()

        const num1 = parseFloat(number1);
        const num2 = parseFloat(number2);

        if(!isNaN(num1) && !isNaN(num2))
        {
            setSum(num1 + num2);
        }
        else{
            setSum(null)
        }
    };

    return (
        <div>
          <form onSubmit={handleSum}>
            <label>
              Number 1:
              <input type="text" value={number1} onChange={handleNumber1Change} />
            </label>
            <br />
            <label>
              Number 2:
              <input type="text" value={number2} onChange={handleNumber2Change} />
            </label>
            <br />
            <button type="submit">Calculate Sum</button>
          </form>
    
          {sum !== null && (
            <div>
              <h2>Sum:</h2>
              <p>{sum}</p>
            </div>
          )}
        </div>
      );
}

export default SumComponent;  // export the component for further usage