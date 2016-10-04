package star.com.pandanatv.model;

import java.util.List;

/**
 * Created by Administrator on 2016/10/4.
 */
public class GameData {
    /**
     * errno : 0
     * errmsg :
     * data : [{"cname":"英雄联盟","ename":"lol","img":"http://i9.pdim.gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg","ext":"1000","status":"1"},{"cname":"守望先锋","ename":"overwatch","img":"http://i1.pdim.gs/t014499e0b3f8338865.png","ext":"1500","status":"1"},{"cname":"炉石传说","ename":"hearthstone","img":"http://i0.pdim.gs/t014b2c62904e1df90f.png","ext":"2000","status":"1"},{"cname":"主机游戏","ename":"zhuji","img":"http://i3.pdim.gs/t017f86a5cb18f2f875.png","ext":"2980","status":"1"},{"cname":"DOTA2","ename":"dota2","img":"http://i3.pdim.gs/t011a29c8f3bcf53c1a.png","ext":"3001","status":"1"},{"cname":"魔兽DOTA1","ename":"war3","img":"http://i7.pdim.gs/2c0e9577b5e15e8d5393aaf9c7956d08.jpeg","ext":"3250","status":"1"},{"cname":"DNF","ename":"dnf","img":"http://i3.pdim.gs/t01a8e22be08ed01772.png","ext":"3499","status":"1"},{"cname":"穿越火线","ename":"cf","img":"http://i0.pdim.gs/t0121cc322a5508b933.png","ext":"3500","status":"1"},{"cname":"魔兽世界","ename":"wow","img":"http://i1.pdim.gs/t0100467bdb40ee6144.png","ext":"3500","status":"1"},{"cname":"暗黑破坏神3","ename":"diablo3","img":"http://i2.pdim.gs/t015fa79d579a60253e.png","ext":"3665","status":"1"},{"cname":"风暴英雄","ename":"heroes","img":"http://i4.pdim.gs/t011a63024f0eac5c65.png","ext":"3676","status":"1"},{"cname":"体育竞技","ename":"spg","img":"http://i2.pdim.gs/t019261a1704ff94a26.png","ext":"4025","status":"1"},{"cname":"我的世界","ename":"mc","img":"http://i2.pdim.gs/t010dcb82863684499a.png","ext":"4030","status":"1"},{"cname":"格斗游戏","ename":"ftg","img":"http://i4.pdim.gs/t0192230355c0e4fe0d.png","ext":"4050","status":"1"},{"cname":"拳皇97","ename":"kof97","img":"http://i9.pdim.gs/40aa07ee68b4f136f79efc79fed86104.jpeg","ext":"4051","status":"1"},{"cname":"剑网3","ename":"jxol3","img":"http://i1.pdim.gs/t01c0b635d7f6dfcca5.jpg","ext":"4490","status":"1"},{"cname":"怀旧经典","ename":"hjjd","img":"http://i4.pdim.gs/t0163e3025692055eb4.png","ext":"5018","status":"1"},{"cname":"CS:GO","ename":"csgo","img":"http://i0.pdim.gs/t01c90135b2bfdf1f08.png","ext":"5052","status":"1"},{"cname":"跑跑卡丁车","ename":"popkart","img":"http://i5.pdim.gs/4510f5affff19c32c14cf8c42d5f2ece.jpeg","ext":"5056","status":"1"},{"cname":"星际争霸2","ename":"starcraft","img":"http://i2.pdim.gs/t010ef069bc6b51ea07.png","ext":"5058","status":"1"},{"cname":"使命召唤OL","ename":"codol","img":"http://i3.pdim.gs/t01d489e46fd91da567.png","ext":"5060","status":"1"},{"cname":"网络游戏","ename":"wy","img":"http://i5.pdim.gs/e8b33c809f23d6bd767be39a4e9c60cd.jpeg","ext":"5060","status":"1"},{"cname":"战争游戏","ename":"shoot","img":"http://i3.pdim.gs/t0117aaf4a25605a1f4.png","ext":"8000","status":"1"},{"cname":"手机游戏","ename":"mobilegame","img":"http://i4.pdim.gs/t01c3a602b302a9f37c.png","ext":"8001","status":"1"},{"cname":"王者荣耀","ename":"kingglory","img":"http://i6.pdim.gs/1288f555f436bbc11a4146e032a5ad4e.png","ext":"8010","status":"1"},{"cname":"棋牌游戏","ename":"qipai","img":"http://i0.pdim.gs/t018b049bac3b39ed6a.png","ext":"8500","status":"1"}]
     * authseq :
     */

    private int errno;
    private String errmsg;
    private String authseq;
    /**
     * cname : 英雄联盟
     * ename : lol
     * img : http://i9.pdim.gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg
     * ext : 1000
     * status : 1
     */

    private List<DataBean> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String cname;
        private String ename;
        private String img;
        private String ext;
        private String status;

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
