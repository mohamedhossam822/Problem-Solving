//jshint esversion:6
var stoneGame = function(piles) {
  let alexScore = 0;
  let leeScore = 0;
  let i = 1;
  while (piles.length > 0) {
    if (piles[0] > piles[piles.length - 1]) {
      if (i % 2 != 0) alexScore = alexScore + piles[0];
      else leeScore = leeScore + piles[0];
      piles.splice(0, 1);
    } else {
      if (i % 2 != 0) alexScore = alexScore + piles[piles.length - 1];
      else leeScore = leeScore + piles[piles.length - 1];
      piles.splice(piles.length - 1, 1);
    }
  }
  if (alexScore > leeScore) return true;
  return false;
};
