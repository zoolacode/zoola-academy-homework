/* eslint-disable jsx-quotes */
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { setStatus } from './redux/slicies/testSlise';

function App() {
  const dispatch = useDispatch();
  const status = useSelector((state) => state.test);

  return (
    <div>
      <p>{status.toString()}</p>
      <button type='submit' onClick={() => dispatch(setStatus())}>
        change status
      </button>
    </div>
  );
}

export default App;
