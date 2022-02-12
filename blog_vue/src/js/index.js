/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-05 15:50:00
 * @LastEditTime: 2022-02-13 00:10:18
 * @LastEditors: gaumn
 */
function getScrollBottomHeight () {
    // 获取整个网页的高的
    let getPageHeight = document.querySelector('html').scrollHeight
    // 获取滚动条卷去的高度
    let getScrollTop = window.pageYOffset ||
                      document.documentElement.scrollTop ||
                      document.body.scrollTop
    // 获取可视区域高度
    let getWindowHeight = window.innerHeight ||
                        document.documentElement.clientHeight
    // 滚动条到底部的距离
    return getPageHeight - getScrollTop - getWindowHeight
}
  
function handleScroll () {
    if (this.getScrollBottomHeight() <= 20) {
      if(this.currentPage<=this.pages){
        this.currentPage++;
        this.isLoading=true;
        this.page(this.currentPage);
      }else{
        this.isLoading=false;
        this.noPage=true;
      }
    }
}
  /**
,
      getScrollBottomHeight () {
        // 获取整个网页的高的
        let getPageHeight = document.querySelector('html').scrollHeight
        // 获取滚动条卷去的高度
        let getScrollTop = window.pageYOffset ||
                          document.documentElement.scrollTop ||
                          document.body.scrollTop
        // 获取可视区域高度
        let getWindowHeight = window.innerHeight ||
                            document.documentElement.clientHeight
        // 滚动条到底部的距离
        return getPageHeight - getScrollTop - getWindowHeight
      },
      handleScrollsss () {
        if (this.getScrollBottomHeight() <= 20) {
          if(this.currentPage<=this.pages){
            this.currentPage++;
            this.isLoading=true;
            this.page(this.currentPage);
          }else{
            this.isLoading=false;
            this.noPage=true;
          }
        }
      }

   */