import React from 'react';
import './UserNameForm.css';

export function UserNameForm({ submitUsername, setDraftUserName }) {
  return (
    <form
      className='form__user-name'
      onSubmit={(e) => {
        submitUsername(e);
      }}
    >
      <label>
        Enter your username:{' '}
        <input onChange={(e) => setDraftUserName(e.target.value)} />
      </label>
    </form>
  );
}
