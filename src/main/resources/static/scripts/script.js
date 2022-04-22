`use strict`

// import the dom
import * as DOM from './dom.js';

// list item function
const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item.id;
  child.innerHTML = `${JSON.stringify(item)}`;
  DOM.listOutput.appendChild(child);
}

// GET all function
const get = () => {
  DOM.listOutput.innerHTML = ``;

  axios.get(`http://localhost:8080/getAll`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem(response.data);
      } else {
        for (let item of response.data) {
          writeItem(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}

// Get a single item by name
const getSingle = () => {
  DOM.listOutput.innerHTML = '';
  let id = DOM.readInputId.value;

  axios.get(`http://localhost:8080/get/${id}`).then(response => {
    if (response.data.id == `${DOM.readInputId.value}`) {
      writeItem(response.data);
    } else {
      console.log("Item not found");
    }
  }).catch(err => {
    console.log(err);
  });
}

const getMake = () => {
  DOM.listOutput.innerHTML = '';
  let make = DOM.readInputMake.value;

  axios.get(`http://localhost:8080/getByMake/${make}`).then(response => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else if (response.data.length == 0) {
      const child = document.createElement(`li`);
      child.innerHTML = `Car of make "${make}" does not exist!`;
      DOM.listOutput.appendChild(child);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });
}

const getModel = () => {
  DOM.listOutput.innerHTML = '';
  let model = DOM.readInputModel.value;

  axios.get(`http://localhost:8080/getByModel/${model}`).then(response => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else if (response.data.length == 0) {
      const child = document.createElement(`li`);
      child.innerHTML = `Car of model "${model}" does not exist!`;
      DOM.listOutput.appendChild(child);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });
}

const getBodyType = () => {
  DOM.listOutput.innerHTML = '';
  let bodyType = DOM.readInputBodyType.value;

  axios.get(`http://localhost:8080/getByBodyType/${bodyType}`).then(response => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else if (response.data.length == 0) {
      const child = document.createElement(`li`);
      child.innerHTML = `Car of body type "${bodyType}" does not exist!`;
      DOM.listOutput.appendChild(child);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });
}

const getFuelType = () => {
  DOM.listOutput.innerHTML = '';
  let fuelType = DOM.readInputFuelType.value;

  axios.get(`http://localhost:8080/getByFuelType/${fuelType}`).then(response => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else if (response.data.length == 0) {
      const child = document.createElement(`li`);
      child.innerHTML = `Car of fuel type "${fuelType}" does not exist!`;
      DOM.listOutput.appendChild(child);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });
}

const getGearbox = () => {
  DOM.listOutput.innerHTML = '';
  let gearbox = DOM.readInputGearbox.value;

  axios.get(`http://localhost:8080/getByGearbox/${gearbox}`).then(response => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else if (response.data.length == 0) {
      const child = document.createElement(`li`);
      child.innerHTML = `Car with gearbox type "${gearbox}" does not exist!`;
      DOM.listOutput.appendChild(child);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });
}

const del = () => {
  let id = DOM.deleteInputId.value;
  
  DOM.listOutput.innerHTML = ``;
  const child = document.createElement(`li`);

  axios.delete(`http://localhost:8080/remove/${id}`).then(response => {
    if (response.status == 204) {
      child.innerHTML = `Car with id: ${id} has been deleted!`;
    }
  }).catch(err => {
    child.innerHTML = `Car entry with id: ${id} doesn't exist!`;
    console.log(err);
  });

  DOM.listOutput.appendChild(child);
}

// POST function
const post = () => {
  axios.post(`/create`, {   make : DOM.inputMake.value,
                            model : DOM.inputModel.value, 
                            bodyType : DOM.inputBodyType.value,
                            gearbox : DOM.inputGearbox.value,
                            fuelType : DOM.inputFuelType.value})
    .then((response) => {
      console.log(response);
      get();
    }).catch((err) => {
      console.log(err);
    });
}

// Setting up the buttons' on click events
DOM.buttonCreate.onclick = () => post();
DOM.buttonRead.onclick = () => getSingle();
DOM.buttonDelete.onclick = () => del();
DOM.buttonReadAll.onclick = () => get();
DOM.buttonReadMake.onclick = () => getMake();
DOM.buttonReadModel.onclick = () => getModel();
DOM.buttonReadBodyType.onclick = () => getBodyType();
DOM.buttonReadFuelType.onclick = () => getFuelType();
DOM.buttonReadGearbox.onclick = () => getGearbox();