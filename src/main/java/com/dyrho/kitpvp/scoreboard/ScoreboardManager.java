package com.dyrho.kitpvp.scoreboard;

import com.dyrho.core.main.Core;
import com.dyrho.core.member.Member;
import com.dyrho.core.utils.scoreboard.PlayerScoreboard;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardManager {

    private List<PlayerScoreboard> playerScoreboardList;

    public ScoreboardManager() {
        playerScoreboardList = new ArrayList<>();
    }


    /*
    This needs to be run on Join, it wil add scoreboard, and add scoreboard to list etc
     */
    public void onJoinEvent(Player p) {
        Member m = Core.getMemberManager().getMember(p);
        PlayerScoreboard board = new PlayerScoreboard(p, "§9§lDyrho - KitPvP");
        board.addLine(1, "&a");                     //
        board.addLine(2, "&b  Welcome &r");         //  Welcome <pname>
        board.addLine(3, "&b");                     //
        board.addLine(4, "&b  Rank:");              //  Rank:
        board.addLine(5, "&c    &f");               //    <rank>
        board.addLine(6, "&d");                     //
        board.addLine(7, "&b  Coins:");             //  Coins:
        board.addLine(8, "&e    &f");               //    <coins>
        board.addLine(9, "&f");                     //
        board.addLine(10, "&b  Gamemodes:");        //  Gamemodes:
        board.addLine(11, "&1&f    ");              //    KitPvP
        board.addLine(12, "&2&f    ");              //    Siege
        board.addLine(13, "&3&f    ");              //    Creative
        board.addLine(14, "&4");                    //
        board.addLine(15, "&b  ");                  //  www.dyrho.com

        board.create();

        board.update(2, p.getName(), "");
        board.update(5, Core.getUtils().getChatUtil().getPrefix(p), "");
        board.update(8, String.valueOf(m.getCoins()), "");
        board.update(11, "Siege", "");
        board.update(12, "KitPvP", "");
        board.update(13, "Creative", "");
        board.update(15, "Store.dyrho.com", "");
        for(PlayerScoreboard playerBoard : playerScoreboardList) {
            playerBoard.addTablist(p);
        }
        playerScoreboardList.add(board);
    }

    /*
    This needs to be run on Quit, it wil remove scoreboard 100%, and remove scoreboard from list etc
     */
    public void onQuitEvent(Player p) {
        PlayerScoreboard playerScoreboard = null;
        for(PlayerScoreboard playerBoard : playerScoreboardList) {
            playerBoard.removeTablist(p);
            if(playerBoard.getPlayer().equals(p)) {
                playerScoreboard = playerBoard;
            }
        }
        if(playerScoreboard != null) {
            playerScoreboard.reset();
            playerScoreboardList.remove(playerScoreboard);
        }
    }

    public void updateRanks() {
        for(PlayerScoreboard board : playerScoreboardList) {
            board.update(5, Core.getUtils().getChatUtil().getPrefix(board.getPlayer()), "");
        }
    }

    public void updateCoins(Member member) {
        for(PlayerScoreboard board : playerScoreboardList) {
            if(board.getPlayer().getName().equalsIgnoreCase(member.getRealname())) {
                board.update(8, String.valueOf(member.getCoins()), "");
            }
        }
    }
}