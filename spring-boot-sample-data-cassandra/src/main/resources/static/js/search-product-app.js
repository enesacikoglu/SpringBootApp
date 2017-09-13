const customersApiUrl = "/api/customer/allCustomers";

new Vue({
	  el: '#app',
	  data () {
	    return {
	      // The resource variable
	      animals: [],
	      // Here you define the url of your paginated API
	      resource_url: 'http://localhost:8080/api/customer/allCustomers'
	    }
	  },
	  components: {
	    VPaginator: VuePaginator
	  },
	  methods: {
	    updateResource(data){
	      this.animals = data
	    }
	  }
	});