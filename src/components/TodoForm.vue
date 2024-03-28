<template>
    <el-form @submit.prevent :inline="true" :model="formInput" class="todo-form-input">
     <el-form-item label="Title" prop="title">
        <el-input v-model="formInput.title" placeholder="輸入待辦事情"></el-input>

     </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onsubmit()">Add</el-button>
        </el-form-item>
    </el-form>
</template>

<script lang="ts">
import { ElMessage } from 'element-plus';
import { Options, Vue } from 'vue-class-component';

@Options({})
export default class TodoForm extends Vue {
    formInput = {title:"", completed: false};

    onsubmit() {
        if(this.formInput.title.length > 0) {
            this.$emit('send-message', this.formInput);
        }else {
            ElMessage({
                message:"不可為空",
                type: "warning"
            })
        }
         this.formInput.title = "";
    }
}

</script>