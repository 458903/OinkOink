<template>
<div>
  <component  v-bind:is="app">
    <router-view v-slot="{ Component }">
      <transition name="aside-right" appear>
        <component :is="Component" />
      </transition>
    </router-view>

  </component>
</div>
</template>