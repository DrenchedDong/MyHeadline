package dongting.bwei.com.headline.bean;

import com.google.gson.annotations.SerializedName;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.List;

public class TuijianBean {

        private int login_status;
        private int total_number;
        private boolean has_more;
        private String post_content_hint;
        private int show_et_status;
        private int feed_flag;
        private String message;
        private boolean has_more_to_refresh;
        private TipsBean tips;
        private List<DataBean> data;

        public int getLogin_status() {
            return login_status;
        }

        public void setLogin_status(int login_status) {
            this.login_status = login_status;
        }

        public int getTotal_number() {
            return total_number;
        }

        public void setTotal_number(int total_number) {
            this.total_number = total_number;
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getPost_content_hint() {
            return post_content_hint;
        }

        public void setPost_content_hint(String post_content_hint) {
            this.post_content_hint = post_content_hint;
        }

        public int getShow_et_status() {
            return show_et_status;
        }

        public void setShow_et_status(int show_et_status) {
            this.show_et_status = show_et_status;
        }

        public int getFeed_flag() {
            return feed_flag;
        }

        public void setFeed_flag(int feed_flag) {
            this.feed_flag = feed_flag;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isHas_more_to_refresh() {
            return has_more_to_refresh;
        }

        public void setHas_more_to_refresh(boolean has_more_to_refresh) {
            this.has_more_to_refresh = has_more_to_refresh;
        }

        public TipsBean getTips() {
            return tips;
        }

        public void setTips(TipsBean tips) {
            this.tips = tips;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class TipsBean {
            /**
             * display_info : 今日头条推荐引擎有8条更新
             * open_url :
             * web_url :
             * app_name : 今日头条
             * package_name :
             * display_template : 今日头条推荐引擎有%s条更新
             * type : app
             * display_duration : 2
             * download_url :
             */

            private String display_info;
            private String open_url;
            private String web_url;
            private String app_name;
            private String package_name;
            private String display_template;
            private String type;
            private int display_duration;
            private String download_url;

            public String getDisplay_info() {
                return display_info;
            }

            public void setDisplay_info(String display_info) {
                this.display_info = display_info;
            }

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public String getApp_name() {
                return app_name;
            }

            public void setApp_name(String app_name) {
                this.app_name = app_name;
            }

            public String getPackage_name() {
                return package_name;
            }

            public void setPackage_name(String package_name) {
                this.package_name = package_name;
            }

            public String getDisplay_template() {
                return display_template;
            }

            public void setDisplay_template(String display_template) {
                this.display_template = display_template;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getDisplay_duration() {
                return display_duration;
            }

            public void setDisplay_duration(int display_duration) {
                this.display_duration = display_duration;
            }

            public String getDownload_url() {
                return download_url;
            }

            public void setDownload_url(String download_url) {
                this.download_url = download_url;
            }
        }

        public static class DataBean {
            /**
             * read_count : 182605
             * media_name : 楚安汽修资料
             * ban_comment : 0
             * abstract : 话说，这个世界上的汽车形形色色，什么样子的都有。但是，就是因为车的种类太多了，很多车标我们都不认识。没关系，今天，咱们就搞一个车标大汇总，随看随查，保证您认的特别全！这份车标大统计中，大概有300多个车标。 如果有哪些我们落下的，欢迎您给我们补充！
             * image_list : [{"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f","width":549,"url_list":[{"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb3.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb9.pstatp.com/list/1bf70006d1edae58362f"}],"uri":"list/1bf70006d1edae58362f","height":308},{"url":"http://p1.pstatp.com/list/1dcb000d7e9a19a20799","width":553,"url_list":[{"url":"http://p1.pstatp.com/list/1dcb000d7e9a19a20799"},{"url":"http://pb3.pstatp.com/list/1dcb000d7e9a19a20799"},{"url":"http://pb9.pstatp.com/list/1dcb000d7e9a19a20799"}],"uri":"list/1dcb000d7e9a19a20799","height":311},{"url":"http://p3.pstatp.com/list/1dcc000d858bfa09781d","width":554,"url_list":[{"url":"http://p3.pstatp.com/list/1dcc000d858bfa09781d"},{"url":"http://pb9.pstatp.com/list/1dcc000d858bfa09781d"},{"url":"http://pb1.pstatp.com/list/1dcc000d858bfa09781d"}],"uri":"list/1dcc000d858bfa09781d","height":311}]
             * has_video : false
             * article_type : 0
             * tag : news_car
             * forward_info : {"forward_count":11}
             * has_m3u8_video : 0
             * keywords : 车标
             * rid : 201705110859420100040151391612BE
             * show_portrait_article : false
             * user_verified : 0
             * aggr_type : 1
             * cell_type : 0
             * article_sub_type : 0
             * bury_count : 1
             * title : 世界最全车标集合~能认识一半我叫你大神！
             * ignore_web_transform : 1
             * source_icon_style : 4
             * tip : 1
             * hot : 1
             * share_url : http://toutiao.com/a6415150038687056130/?iid=3642583580&app=news_article
             * has_mp4_video : 0
             * source : 楚安汽修资料
             * comment_count : 170
             * article_url : http://toutiao.com/group/6415150038687056130/
             * filter_words : [{"id":"8:0","name":"重复、旧闻","is_selected":false},{"id":"9:1","name":"内容质量差","is_selected":false},{"id":"5:766082906","name":"来源:楚安汽修资料","is_selected":false},{"id":"6:562632","name":"车标","is_selected":false}]
             * share_count : 8017
             * publish_time : 1493947971
             * action_list : [{"action":1,"extra":{},"desc":""},{"action":3,"extra":{},"desc":""},{"action":7,"extra":{},"desc":""},{"action":9,"extra":{},"desc":""}]
             * gallary_image_count : 6
             * cell_layout_style : 1
             * tag_id : 6415150038687056130
             * action_extra : {"channel_id": 3189398993}
             * video_style : 0
             * verified_content :
             * display_url : http://toutiao.com/group/6415150038687056130/
             * large_image_list : []
             * item_id : 6415798668376408577
             * is_subject : false
             * show_portrait : false
             * repin_count : 25715
             * cell_flag : 11
             * user_info : {"verified_content":"","avatar_url":"http://p1.pstatp.com/thumb/e59000f3a39dcd5f2ec","user_id":52177476743,"name":"楚安汽修资料","follower_count":0,"follow":false,"user_auth_info":"","user_verified":false,"description":"汽修行业的良师益友！"}
             * source_open_url : sslocal://profile?uid=52177476743
             * level : 0
             * like_count : 11
             * digg_count : 11
             * behot_time : 1494464382
             * cursor : 1494464382999
             * url : http://toutiao.com/group/6415150038687056130/
             * preload_web : 1
             * user_repin : 0
             * has_image : true
             * item_version : 0
             * media_info : {"user_id":52177476743,"verified_content":"","avatar_url":"http://p3.pstatp.com/large/e59000f3a39dcd5f2ec","media_id":52177587849,"name":"楚安汽修资料","recommend_type":0,"follow":false,"recommend_reason":"","is_star_user":false,"user_verified":false}
             * group_id : 6415150038687056130
             * middle_image : {"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f","width":549,"url_list":[{"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb3.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb9.pstatp.com/list/1bf70006d1edae58362f"}],"uri":"list/1bf70006d1edae58362f","height":308}
             * log_extra : {"rit": 1, "convert_id": 0, "req_id": "201705110859420100040151391612BE", "ad_price": "WRG2CQAN8qNZEbYJAA3yo9NLdoiAB3XJo-6ykQ"}
             * more_mode : true
             * display_info : 正规一年制本科,一键解决你的学历问题!
             * label : 广告
             * expire_seconds : 0
             * ad_id : 60065849971
             * natant_level : 2
             * article_alt_url : http://toutiao.com/group/article/6418376558142030082/?ad_id=60060196400&cid=60065849971&req_id=201705110859420100040151391612BE
             * ad_label : 广告
             */

            private int read_count;
            private String media_name;
            private int ban_comment;
            @SerializedName("abstract")
            private String abstractX;
            private boolean has_video;
            private int article_type;
            private String tag;
            private ForwardInfoBean forward_info;
            private int has_m3u8_video;
            private String keywords;
            private String rid;
            private boolean show_portrait_article;
            private int user_verified;
            private int aggr_type;
            private int cell_type;
            private int article_sub_type;
            private int bury_count;
            private String title;
            private int ignore_web_transform;
            private int source_icon_style;
            private int tip;
            private int hot;
            private String share_url;
            private int has_mp4_video;
            private String source;
            private int comment_count;
            private String article_url;
            private int share_count;
            private int publish_time;
            private int gallary_image_count;
            private int cell_layout_style;
            private long tag_id;
            private String action_extra;
            private int video_style;
            private String verified_content;
            private String display_url;
            private long item_id;
            private boolean is_subject;
            private boolean show_portrait;
            private int repin_count;
            private int cell_flag;
            private UserInfoBean user_info;
            private String source_open_url;
            private int level;
            private int like_count;
            private int digg_count;
            private int behot_time;
            private long cursor;
            private String url;
            private int preload_web;
            private int user_repin;
            private boolean has_image;
            private int item_version;
            private MediaInfoBean media_info;
            private long group_id;
            private MiddleImageBean middle_image;
            private String log_extra;
            private boolean more_mode;
            private String display_info;
            private String label;
            private int expire_seconds;
            private long ad_id;
            private int natant_level;
            private String article_alt_url;
            private String ad_label;
            private List<ImageListBean> image_list;
            private List<FilterWordsBean> filter_words;
            private List<ActionListBean> action_list;
            private List<LargeImageBean> large_image_list;

            public int getRead_count() {
                return read_count;
            }

            public void setRead_count(int read_count) {
                this.read_count = read_count;
            }

            public String getMedia_name() {
                return media_name;
            }

            public void setMedia_name(String media_name) {
                this.media_name = media_name;
            }

            public int getBan_comment() {
                return ban_comment;
            }

            public void setBan_comment(int ban_comment) {
                this.ban_comment = ban_comment;
            }

            public String getAbstractX() {
                return abstractX;
            }

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public int getArticle_type() {
                return article_type;
            }

            public void setArticle_type(int article_type) {
                this.article_type = article_type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public ForwardInfoBean getForward_info() {
                return forward_info;
            }

            public void setForward_info(ForwardInfoBean forward_info) {
                this.forward_info = forward_info;
            }

            public int getHas_m3u8_video() {
                return has_m3u8_video;
            }

            public void setHas_m3u8_video(int has_m3u8_video) {
                this.has_m3u8_video = has_m3u8_video;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getRid() {
                return rid;
            }

            public void setRid(String rid) {
                this.rid = rid;
            }

            public boolean isShow_portrait_article() {
                return show_portrait_article;
            }

            public void setShow_portrait_article(boolean show_portrait_article) {
                this.show_portrait_article = show_portrait_article;
            }

            public int getUser_verified() {
                return user_verified;
            }

            public void setUser_verified(int user_verified) {
                this.user_verified = user_verified;
            }

            public int getAggr_type() {
                return aggr_type;
            }

            public void setAggr_type(int aggr_type) {
                this.aggr_type = aggr_type;
            }

            public int getCell_type() {
                return cell_type;
            }

            public void setCell_type(int cell_type) {
                this.cell_type = cell_type;
            }

            public int getArticle_sub_type() {
                return article_sub_type;
            }

            public void setArticle_sub_type(int article_sub_type) {
                this.article_sub_type = article_sub_type;
            }

            public int getBury_count() {
                return bury_count;
            }

            public void setBury_count(int bury_count) {
                this.bury_count = bury_count;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIgnore_web_transform() {
                return ignore_web_transform;
            }

            public void setIgnore_web_transform(int ignore_web_transform) {
                this.ignore_web_transform = ignore_web_transform;
            }

            public int getSource_icon_style() {
                return source_icon_style;
            }

            public void setSource_icon_style(int source_icon_style) {
                this.source_icon_style = source_icon_style;
            }

            public int getTip() {
                return tip;
            }

            public void setTip(int tip) {
                this.tip = tip;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public int getHas_mp4_video() {
                return has_mp4_video;
            }

            public void setHas_mp4_video(int has_mp4_video) {
                this.has_mp4_video = has_mp4_video;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public String getArticle_url() {
                return article_url;
            }

            public void setArticle_url(String article_url) {
                this.article_url = article_url;
            }

            public int getShare_count() {
                return share_count;
            }

            public void setShare_count(int share_count) {
                this.share_count = share_count;
            }

            public int getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(int publish_time) {
                this.publish_time = publish_time;
            }

            public int getGallary_image_count() {
                return gallary_image_count;
            }

            public void setGallary_image_count(int gallary_image_count) {
                this.gallary_image_count = gallary_image_count;
            }

            public int getCell_layout_style() {
                return cell_layout_style;
            }

            public void setCell_layout_style(int cell_layout_style) {
                this.cell_layout_style = cell_layout_style;
            }

            public long getTag_id() {
                return tag_id;
            }

            public void setTag_id(long tag_id) {
                this.tag_id = tag_id;
            }

            public String getAction_extra() {
                return action_extra;
            }

            public void setAction_extra(String action_extra) {
                this.action_extra = action_extra;
            }

            public int getVideo_style() {
                return video_style;
            }

            public void setVideo_style(int video_style) {
                this.video_style = video_style;
            }

            public String getVerified_content() {
                return verified_content;
            }

            public void setVerified_content(String verified_content) {
                this.verified_content = verified_content;
            }

            public String getDisplay_url() {
                return display_url;
            }

            public void setDisplay_url(String display_url) {
                this.display_url = display_url;
            }

            public long getItem_id() {
                return item_id;
            }

            public void setItem_id(long item_id) {
                this.item_id = item_id;
            }

            public boolean isIs_subject() {
                return is_subject;
            }

            public void setIs_subject(boolean is_subject) {
                this.is_subject = is_subject;
            }

            public boolean isShow_portrait() {
                return show_portrait;
            }

            public void setShow_portrait(boolean show_portrait) {
                this.show_portrait = show_portrait;
            }

            public int getRepin_count() {
                return repin_count;
            }

            public void setRepin_count(int repin_count) {
                this.repin_count = repin_count;
            }

            public int getCell_flag() {
                return cell_flag;
            }

            public void setCell_flag(int cell_flag) {
                this.cell_flag = cell_flag;
            }

            public UserInfoBean getUser_info() {
                return user_info;
            }

            public void setUser_info(UserInfoBean user_info) {
                this.user_info = user_info;
            }

            public String getSource_open_url() {
                return source_open_url;
            }

            public void setSource_open_url(String source_open_url) {
                this.source_open_url = source_open_url;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public int getBehot_time() {
                return behot_time;
            }

            public void setBehot_time(int behot_time) {
                this.behot_time = behot_time;
            }

            public long getCursor() {
                return cursor;
            }

            public void setCursor(long cursor) {
                this.cursor = cursor;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getPreload_web() {
                return preload_web;
            }

            public void setPreload_web(int preload_web) {
                this.preload_web = preload_web;
            }

            public int getUser_repin() {
                return user_repin;
            }

            public void setUser_repin(int user_repin) {
                this.user_repin = user_repin;
            }

            public boolean isHas_image() {
                return has_image;
            }

            public void setHas_image(boolean has_image) {
                this.has_image = has_image;
            }

            public int getItem_version() {
                return item_version;
            }

            public void setItem_version(int item_version) {
                this.item_version = item_version;
            }

            public MediaInfoBean getMedia_info() {
                return media_info;
            }

            public void setMedia_info(MediaInfoBean media_info) {
                this.media_info = media_info;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public MiddleImageBean getMiddle_image() {
                return middle_image;
            }

            public void setMiddle_image(MiddleImageBean middle_image) {
                this.middle_image = middle_image;
            }

            public String getLog_extra() {
                return log_extra;
            }

            public void setLog_extra(String log_extra) {
                this.log_extra = log_extra;
            }

            public boolean isMore_mode() {
                return more_mode;
            }

            public void setMore_mode(boolean more_mode) {
                this.more_mode = more_mode;
            }

            public String getDisplay_info() {
                return display_info;
            }

            public void setDisplay_info(String display_info) {
                this.display_info = display_info;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getExpire_seconds() {
                return expire_seconds;
            }

            public void setExpire_seconds(int expire_seconds) {
                this.expire_seconds = expire_seconds;
            }

            public long getAd_id() {
                return ad_id;
            }

            public void setAd_id(long ad_id) {
                this.ad_id = ad_id;
            }

            public int getNatant_level() {
                return natant_level;
            }

            public void setNatant_level(int natant_level) {
                this.natant_level = natant_level;
            }

            public String getArticle_alt_url() {
                return article_alt_url;
            }

            public void setArticle_alt_url(String article_alt_url) {
                this.article_alt_url = article_alt_url;
            }

            public String getAd_label() {
                return ad_label;
            }

            public void setAd_label(String ad_label) {
                this.ad_label = ad_label;
            }

            public List<ImageListBean> getImage_list() {
                return image_list;
            }

            public void setImage_list(List<ImageListBean> image_list) {
                this.image_list = image_list;
            }

            public List<FilterWordsBean> getFilter_words() {
                return filter_words;
            }

            public void setFilter_words(List<FilterWordsBean> filter_words) {
                this.filter_words = filter_words;
            }

            public List<ActionListBean> getAction_list() {
                return action_list;
            }

            public void setAction_list(List<ActionListBean> action_list) {
                this.action_list = action_list;
            }

            public List<LargeImageBean> getLarge_image_list() {
                return large_image_list;
            }

            public void setLarge_image_list(List<LargeImageBean> large_image_list) {
                this.large_image_list = large_image_list;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "read_count=" + read_count +
                        ", media_name='" + media_name + '\'' +
                        ", ban_comment=" + ban_comment +
                        ", abstractX='" + abstractX + '\'' +
                        ", has_video=" + has_video +
                        ", article_type=" + article_type +
                        ", tag='" + tag + '\'' +
                        ", forward_info=" + forward_info +
                        ", has_m3u8_video=" + has_m3u8_video +
                        ", keywords='" + keywords + '\'' +
                        ", rid='" + rid + '\'' +
                        ", show_portrait_article=" + show_portrait_article +
                        ", user_verified=" + user_verified +
                        ", aggr_type=" + aggr_type +
                        ", cell_type=" + cell_type +
                        ", article_sub_type=" + article_sub_type +
                        ", bury_count=" + bury_count +
                        ", title='" + title + '\'' +
                        ", ignore_web_transform=" + ignore_web_transform +
                        ", source_icon_style=" + source_icon_style +
                        ", tip=" + tip +
                        ", hot=" + hot +
                        ", share_url='" + share_url + '\'' +
                        ", has_mp4_video=" + has_mp4_video +
                        ", source='" + source + '\'' +
                        ", comment_count=" + comment_count +
                        ", article_url='" + article_url + '\'' +
                        ", share_count=" + share_count +
                        ", publish_time=" + publish_time +
                        ", gallary_image_count=" + gallary_image_count +
                        ", cell_layout_style=" + cell_layout_style +
                        ", tag_id=" + tag_id +
                        ", action_extra='" + action_extra + '\'' +
                        ", video_style=" + video_style +
                        ", verified_content='" + verified_content + '\'' +
                        ", display_url='" + display_url + '\'' +
                        ", item_id=" + item_id +
                        ", is_subject=" + is_subject +
                        ", show_portrait=" + show_portrait +
                        ", repin_count=" + repin_count +
                        ", cell_flag=" + cell_flag +
                        ", user_info=" + user_info +
                        ", source_open_url='" + source_open_url + '\'' +
                        ", level=" + level +
                        ", like_count=" + like_count +
                        ", digg_count=" + digg_count +
                        ", behot_time=" + behot_time +
                        ", cursor=" + cursor +
                        ", url='" + url + '\'' +
                        ", preload_web=" + preload_web +
                        ", user_repin=" + user_repin +
                        ", has_image=" + has_image +
                        ", item_version=" + item_version +
                        ", media_info=" + media_info +
                        ", group_id=" + group_id +
                        ", middle_image=" + middle_image +
                        ", log_extra='" + log_extra + '\'' +
                        ", more_mode=" + more_mode +
                        ", display_info='" + display_info + '\'' +
                        ", label='" + label + '\'' +
                        ", expire_seconds=" + expire_seconds +
                        ", ad_id=" + ad_id +
                        ", natant_level=" + natant_level +
                        ", article_alt_url='" + article_alt_url + '\'' +
                        ", ad_label='" + ad_label + '\'' +
                        ", image_list=" + image_list +
                        ", filter_words=" + filter_words +
                        ", action_list=" + action_list +
                        ", large_image_list=" + large_image_list +
                        '}';
            }

            public static class ForwardInfoBean {
                /**
                 * forward_count : 11
                 */

                private int forward_count;

                public int getForward_count() {
                    return forward_count;
                }

                public void setForward_count(int forward_count) {
                    this.forward_count = forward_count;
                }
            }

            public static class LargeImageBean {
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class UserInfoBean {
                /**
                 * verified_content :
                 * avatar_url : http://p1.pstatp.com/thumb/e59000f3a39dcd5f2ec
                 * user_id : 52177476743
                 * name : 楚安汽修资料
                 * follower_count : 0
                 * follow : false
                 * user_auth_info :
                 * user_verified : false
                 * description : 汽修行业的良师益友！
                 */

                private String verified_content;
                private String avatar_url;
                private long user_id;
                private String name;
                private int follower_count;
                private boolean follow;
                private String user_auth_info;
                private boolean user_verified;
                private String description;

                public String getVerified_content() {
                    return verified_content;
                }

                public void setVerified_content(String verified_content) {
                    this.verified_content = verified_content;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getFollower_count() {
                    return follower_count;
                }

                public void setFollower_count(int follower_count) {
                    this.follower_count = follower_count;
                }

                public boolean isFollow() {
                    return follow;
                }

                public void setFollow(boolean follow) {
                    this.follow = follow;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }

            public static class MediaInfoBean {
                /**
                 * user_id : 52177476743
                 * verified_content :
                 * avatar_url : http://p3.pstatp.com/large/e59000f3a39dcd5f2ec
                 * media_id : 52177587849
                 * name : 楚安汽修资料
                 * recommend_type : 0
                 * follow : false
                 * recommend_reason :
                 * is_star_user : false
                 * user_verified : false
                 */

                private long user_id;
                private String verified_content;
                private String avatar_url;
                private long media_id;
                private String name;
                private int recommend_type;
                private boolean follow;
                private String recommend_reason;
                private boolean is_star_user;
                private boolean user_verified;

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getVerified_content() {
                    return verified_content;
                }

                public void setVerified_content(String verified_content) {
                    this.verified_content = verified_content;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public long getMedia_id() {
                    return media_id;
                }

                public void setMedia_id(long media_id) {
                    this.media_id = media_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getRecommend_type() {
                    return recommend_type;
                }

                public void setRecommend_type(int recommend_type) {
                    this.recommend_type = recommend_type;
                }

                public boolean isFollow() {
                    return follow;
                }

                public void setFollow(boolean follow) {
                    this.follow = follow;
                }

                public String getRecommend_reason() {
                    return recommend_reason;
                }

                public void setRecommend_reason(String recommend_reason) {
                    this.recommend_reason = recommend_reason;
                }

                public boolean isIs_star_user() {
                    return is_star_user;
                }

                public void setIs_star_user(boolean is_star_user) {
                    this.is_star_user = is_star_user;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }
            }

            public static class MiddleImageBean {
                /**
                 * url : http://p1.pstatp.com/list/1bf70006d1edae58362f
                 * width : 549
                 * url_list : [{"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb3.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb9.pstatp.com/list/1bf70006d1edae58362f"}]
                 * uri : list/1bf70006d1edae58362f
                 * height : 308
                 */
                private String url;
                private int width;
                private String uri;
                private int height;
                private List<UrlListBean> url_list;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public List<UrlListBean> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBean> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBean {
                    /**
                     * url : http://p1.pstatp.com/list/1bf70006d1edae58362f
                     */

                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            public static class ImageListBean {
                /**
                 * url : http://p1.pstatp.com/list/1bf70006d1edae58362f
                 * width : 549
                 * url_list : [{"url":"http://p1.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb3.pstatp.com/list/1bf70006d1edae58362f"},{"url":"http://pb9.pstatp.com/list/1bf70006d1edae58362f"}]
                 * uri : list/1bf70006d1edae58362f
                 * height : 308
                 */

                private String url;
                private int width;
                private String uri;
                private int height;
                private List<UrlListBeanX> url_list;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public List<UrlListBeanX> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBeanX> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBeanX {
                    /**
                     * url : http://p1.pstatp.com/list/1bf70006d1edae58362f
                     */

                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            public static class FilterWordsBean {
                /**
                 * id : 8:0
                 * name : 重复、旧闻
                 * is_selected : false
                 */

                private String id;
                private String name;
                private boolean is_selected;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isIs_selected() {
                    return is_selected;
                }

                public void setIs_selected(boolean is_selected) {
                    this.is_selected = is_selected;
                }
            }

            public static class ActionListBean {
                /**
                 * action : 1
                 * extra : {}
                 * desc :
                 */

                private int action;
                private ExtraBean extra;
                private String desc;

                public int getAction() {
                    return action;
                }

                public void setAction(int action) {
                    this.action = action;
                }

                public ExtraBean getExtra() {
                    return extra;
                }

                public void setExtra(ExtraBean extra) {
                    this.extra = extra;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public static class ExtraBean {
                }
            }
        }
    }
