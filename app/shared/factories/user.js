app.factory("userService", function() {
    return {
        user : {
        },

      isConnected : function() {
            return (this.user.id);
        }
    }
});
