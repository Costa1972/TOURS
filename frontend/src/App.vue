<template>
  <div class="app">
    <div class="title">
      <h2>Добавить участника</h2>
    </div>
    <form class="person_data">
      <input class="input"
             v-bind:value="lastname"
             @input="lastname = $event.target.value"
             type="text"
             placeholder="Фамилия"/>
      <input class="input"
             v-bind:value="name"
             @input="name = $event.target.value"
             type="text"
             placeholder="Имя"/>
      <input
          class="input"
          v-bind:value="patronymic"
          @input="patronymic = $event.target.value"
          type="text"
          placeholder="Отчество"/>
      <input
          class="input"
          v-bind:value="phone"
          @input="phone = $event.target.value"
          type="text"
          placeholder="Телефон"/>
      <input
          class="input"
          v-bind:value="email"
          @input="email = $event.target.value"
          type="email"
          placeholder="Email"/>

      <button class="btn"
              @click="addPerson">Отправить
      </button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      patronymic: '',
      lastname: '',
      phone: '',
      email: '',

    }
  },
  methods: {
    addPerson() {
      const newPerson = {
        name: this.name,
        patronymic: this.patronymic,
        lastname: this.lastname,
        phone: this.phone,
        email: this.email,
      }
    }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

.app {
  padding: 20px;
}

.title {
  text-align: center;
  padding-top: 20px;
  padding-bottom: 20px;
  color: teal;
}

.person_data {
  display: flex;
  flex-direction: column;
}

.input {
  width: 100%;
  padding: 10px;
  border: 3px solid teal;
  border-radius: 5px;
  margin-top: 15px;
  color: black;
}

.btn {
  padding: 10px 15px;
  background: none;
  font-size: 16px;
  color: darkslategrey;
  border: 2px solid teal;
  border-radius: 5px;
  margin-top: 20px;
  align-self: flex-end;
}
</style>