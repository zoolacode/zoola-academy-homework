import { createUseStyles } from 'react-jss';

const formStyles = createUseStyles({
  loginForm: {
    display: 'flex',
    flexDirection: 'column',
    width: '100%',
    alignItems: 'center',
    marginTop: '10vh'
  }
});

function Form({ children, onSubmit }) {
  const classes = formStyles();
  return (
    <>
      <form className={classes.loginForm} onSubmit={onSubmit}>{children}</form>
    </>
  );
}

export default Form;
