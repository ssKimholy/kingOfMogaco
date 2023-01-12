import MyButton from './component/MyButton';

 

function App() {

  return (    

    <div className="App">
      <MyButton incrementer={1} />

      <MyButton incrementer={10} />

      <MyButton incrementer={15} />
    </div>
  );

}

 

export default App;
