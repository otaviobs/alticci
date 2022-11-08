import React, { useState } from 'react'

const Number = () => {
    const ALTICCI_API_BASE_URL = "http://localhost:8081/alticci";
    const [index, setIndex] = useState(0);
    const [message, setMessage] = useState("");
    

    const checkNumber = async (e: any) => {
        e.preventDefault();

        if(String(index).trim().length == 0){
            alert("Input a number, please! Between zero and seventy eight.");
            return false;
        }

        if(index < 0 || index > 78){
            alert("Input the correct number, please! Between zero and seventy eight.");
            return false;
        }

        const response = await fetch(ALTICCI_API_BASE_URL+"/"+index, {
            method: "GET",
            headers:{
                "Content-Type": "application/json"
            }
        });
        const result = await response.json();
        if(!response.ok){
            throw new Error(result.message);
        }
        console.log(result.number);
        setMessage(result.number);

    }

  return (
    <div className='container mx-auto my-8'>
        <div className='h-12'>
            <div className='h-14 my-4 grid grid-cols-6 gap-6'>
                <div className='col-span-6 sm:col-span-3'>
                    <label className='block text-gray-600 text-sm font-normal'>Number</label>
                    <input
                        type="number"
                        name="number"
                        min="0"
                        max="78"
                        step="1"
                        value={index}
                        onChange={(e: any) => setIndex(e.target.value)}                        
                        className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
                <div className='col-span-6 sm:col-span-3'>
                    <label className='block text-gray-600 text-sm font-normal'>Result</label>
                    <p className='bg-gray-400 text-white h-10 w-96 border mt-2 px-2 py-2'>{message}</p>
                </div>
            </div>

            <button 
                onClick={checkNumber}
                className='rounded bg-green-400 hover:bg-green-800 text-white px-6 py-2 font-semibold'>
                CHECK
            </button>

        </div>
        
    </div>
  )
}

export default Number