package nh.desigh.builder;

/**
 * 1.首先你得创建一个静态内部类Builder，并把所有外部类的参数复制到该类中。
 * 建议在命名该内部类时，尽量在外部类后面加上Builder字样，例如，外部类名为Computer，该内部类名字为ComputerBuilder。
 * 2.该内部建造者类要具有一个public类型的构造函数，该构造函数以必需的属性值为参数。
 * 3.建造者类具有赋值可选参数的方法，并且方法的返回值时该类本身。
 * 4.最后，建造者类须提供一个类似于build()的方法，返回一个外部类实例。因此外部类需要一个以Builder的实例对象为参数的私有构造函数。
 * 并在这个函数中给外部类的属性变量赋值。
 * <p>
 * 一个简单的组建广告例子，广告类型：纯文字，图文，视频类
 */
class buildAd {
    public static void main(String[] args) {
        //构建一个视频广告
        String title = "";
        String[] tracks = {"", ""};
        String videourl = "";
        Ad videoAd = new Ad.AdBuilder(title, tracks).buildvideo(videourl).build();
    }
}

public class Ad {
    private String title;
    private String description;
    private String icon;
    private String[] images;
    private String video;
    private String[] tracks;

    //外部类需要一个以Builder的实例对象为参数的私有构造函数
    private Ad(String title, String description, String icon, String[] images, String video, String[] tracks) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.images = images;
        this.video = video;
        this.tracks = tracks;
    }

    //静态内部类
    public static class AdBuilder {
        private String title;
        private String description;
        private String icon;
        private String[] images;
        private String video;
        private String[] tracks;

        /**
         * public类型的构造函数
         * title 和tracks 都不可为空
         **/
        public AdBuilder(String title, String[] tracks) {
            this.title = title;
            this.tracks = tracks;
        }

        //具有赋值可选参数的方法，并且方法的返回值时该类本身
        public AdBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public AdBuilder setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public AdBuilder setImages(String[] images) {
            this.images = images;
            return this;
        }

        public AdBuilder setVideo(String video) {
            this.video = video;
            return this;
        }

        public AdBuilder setTracks(String[] tracks) {
            this.tracks = tracks;
            return this;
        }

        public AdBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        //文字链
        public AdBuilder buildText() {
            return this;
        }

        //图文
        public AdBuilder buildCard(String[] images) {
            this.images = images;
            return this;
        }

        //视频类
        public AdBuilder buildvideo(String video) {
            this.video = video;
            return this;
        }

        //提供一个类似于build()的方法，返回一个外部类实例
        public Ad build() {
            return new Ad(this.title, this.description, this.icon, this.images, this.video, this.tracks);
        }
    }
}
