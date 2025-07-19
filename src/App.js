import logo from './logo.svg';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';
import Home from './Components/Home'
import Dashboard from './Components/Dashboard'
function App() {
  return (
    // <div className="App">
    //   <Home/>
    // </div>
    <Router>
      <Routes>
        <Route path='/' element={<Home/>} />
        <Route path='/dashboard' element={<Dashboard />} />
      </Routes>
    </Router>
  );
}

export default App;
