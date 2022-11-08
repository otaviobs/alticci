import React from 'react'

const Legend = () => {
  return (
    <div className='h-14 my-4 border text-center'>
        <p>
          Input a number between 0 and 78 because the API is working with Integer type that has a limit number.
          <br />
          <small>*It has a low range of numbers because the task description show lows numbers</small>
        </p>
    </div>
  )
}

export default Legend