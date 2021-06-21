function solution(participant, completion) {
  participant.sort();
  completion.sort();

  var i;
  for (i = 0; i < completion.length; i++) {
    if (participant[i] != completion[i]) return participant[i];
  }

  return participant[i];
}
