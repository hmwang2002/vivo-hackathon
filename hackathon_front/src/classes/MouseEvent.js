import * as Cesium from 'cesium';

export default class MouseEvent {
    init(viewer) {
        this.viewer = viewer;
        this.initEvents();
        this.ret = undefined;
        this.positions = [];        //存储确定点位
        this.tempPositions = [];    //存储点位
        this.vertexEntities = [];   //存储点位实体
        this.lineEntities = [];     //存储线实体
        this.labelEntity = undefined;
        this.measureDistance = 0; //测量结果
        this.isMeasure = false;
    }

    // 初始化事务
    initEvents() {
        this.handler = new Cesium.ScreenSpaceEventHandler(this.viewer.scene.canvas);
        this.mouseEvent = new Cesium.Event(); //开始事件
    }

    // 点击获取位置的经纬度
    getClickPosition() {
        this.handler.setInputAction((clickEvent) => {
            let position = this.viewer.scene.pickPosition(clickEvent.position);
            //console.log(position);
            if (!position) {
                position = this.viewer.scene.camera.pickEllipsoid(clickEvent.position, this.viewer.scene.globe.ellipsoid);
            }
            if (!position) return;
            this.ret = position;
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        //console.log(this.ret);
        let res = this.ret;
        this.ret = undefined;
        return res;
    }


}