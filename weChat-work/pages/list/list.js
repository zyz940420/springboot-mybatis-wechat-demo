// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8082/springboot-mybatis/superAdmin/listArea',
      method: 'GET',
      data: {},
      success: function (res) {
        //debugger;
        var list = res.data.areaList;
        if (list == null) {
          var toastText = "获取数据失败，" + res.data.errMessage;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            list: list
          });
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 新增函数
   */
  addArea: function () {
    wx.navigateTo({
      url: '../operation/operation',
    })
  },

  /**
   * 删除函数
   */
  deleteArea: function (param) {
    //1、保存句柄
    var that = this;
    //2、弹出提示窗口，是否删除
    wx.showModal({
      title: '提示',
      content: '确定要删除【' + param.target.dataset.areaname + '】吗？',
      success: function (sm) {
        //3、如果提示框确认删除，调用请求
        if (sm.confirm) {
          //debugger;
          wx.request({
            url: 'http://localhost:8082/springboot-mybatis/superAdmin/removeArea',
            data: { "areaId": param.target.dataset.areaid },
            method: 'GET',
            
            success: function (response) {
              var result = response.data.success;
              var toastText = "删除成功！";
              if (result != true) {
                toastText = "删除失败！";
              } else {
                //5、如果删除成功，调用api把表格数减一，并设置data
                that.data.list.splice(param.target.dataset.index, 1)
                that.setData({
                  list: that.data.list
                });
              }

              //4、请求成功或失败，都执行提示窗口
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              })
            }
          })
        }
      }
    })
  },

})